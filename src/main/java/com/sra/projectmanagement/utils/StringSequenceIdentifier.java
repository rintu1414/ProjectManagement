package com.sra.projectmanagement.utils;


import org.hibernate.engine.spi.SharedSessionContractImplementor;

import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StringSequenceIdentifier implements IdentifierGenerator {

    private String DEFAULT_SEQUENCE_NAME = "hibernate_sequence";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        if (obj instanceof Identifiable) {
            Identifiable identifiable = (Identifiable) obj;
            Serializable id = identifiable.getId();
            if (id != null) {
                return id;
            }
        }
        Serializable result = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String prefix = "AR-";
            connection = session.connection();
            statement = connection.createStatement();

            try {
                resultSet = statement.executeQuery("SELECT MAX(risk_no) FROM " +DEFAULT_SEQUENCE_NAME);
            } catch (Exception e) {
                ResultSet tables = connection.getMetaData().getTables(null, null, DEFAULT_SEQUENCE_NAME, null);
                if (tables.next()) {
                    System.out.println("Customer Table Exists !");
                } else {
                    // if sequence is not found then creating the sequence
                    statement = connection.createStatement();
                    statement.execute("CREATE TABLE " + DEFAULT_SEQUENCE_NAME + "(risk_no INT(4) AUTO_INCREMENT PRIMARY KEY)");
                    System.out.println("Sequece Created successfully. ");
                    resultSet = statement.executeQuery("SELECT MAX(risk_no) FROM " + DEFAULT_SEQUENCE_NAME);

                }
            }
            if (!resultSet.next()) return result;
            int nextValue = resultSet.getInt(1);
            String suffix = String.format("%05d", nextValue + 1);
            result = prefix.concat(suffix);
            System.out.println("Custom generated Sequence value : "+result);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}