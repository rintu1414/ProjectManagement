package com.sra.projectmanagement.utils;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.*;

public class StringSequenceIdentifier implements IdentifierGenerator {
    private static final Logger LOG = LoggerFactory.getLogger("StringSequenceIdentifier");
     @Override
    public Serializable generate(SharedSessionContractImplementor si, Object o) {

        String riskID = "";
         String prefix ="";
        int defaultNumber = 1;
        String digits = "";
        String defaultPrefix = "AR-";
        PreparedStatement pst = null;
        Connection con = si.connection();
        try {
           pst = con.prepareStatement("SELECT risk_id FROM "+"risk_register ");
            ResultSet rs = pst.executeQuery();
           if (rs != null) {
               while(rs.next()) {

                   riskID = rs.getString("risk_id");
                   LOG.info("Risk created in DB : {}", riskID);

                   prefix = riskID.substring(0, 3);
                   LOG.info("Risk created in DB : prefix", prefix);

                   String str[] = riskID.split(prefix);
                   LOG.info("Risk created in DB : str[]", riskID.split(prefix));

                   digits = String.format("%06d", Integer.parseInt(str[1]) + 1);
                   LOG.info("Risk created in DB : digits", digits);

                   riskID = prefix.concat(digits);
               }

            } else {

                digits = String.format("%06d", defaultNumber);

               riskID = defaultPrefix.concat(digits);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return riskID;

    }

}