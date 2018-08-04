package com.sra.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sra.projectmanagement.utils.Identifiable;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RISK_REGISTER")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class RiskRegister implements Serializable, Identifiable<String> {

    @Id
    @GeneratedValue(
            generator = "assigned-sequence",
            strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "assigned-sequence",
            strategy = "com.sra.projectmanagement.utils.StringSequenceIdentifier"
    )

    @Column(name = "risk_id")
    private String id;


    @Temporal(TemporalType.DATE)
    private Date dateIndented;

    private String riskCategory;

    private String riskDescription;

    private String riskOwner;

    private String impact;

    private String contributingFactor;

    private String currentControl;

    private String currentControlEvaluation;

    private String likelihood;

    private String severity;

    private int rank;

    private String rankDescription;

    private String response;

    private String responsePlan;

    private String actualAction;


    @Temporal(TemporalType.DATE)
    private Date dueDate;

    private String status;


    public RiskRegister() {
    }

    public RiskRegister(String id, Date dateIndented, String riskCategory) {
        this.id = id;
        this.dateIndented = dateIndented;
        this.riskCategory = riskCategory;
    }
/*    public RiskRegister(String id, Date dateIndented, String riskCategory, String riskDescription, String riskOwner, String impact, String contributingFactor, String currentControl, String currentControlEvaluation, String likelihood, String severity, int rank, String rankDescription, String response, String responsePlan, String actualAction, Date dueDate, String status) {
        this.id = id;
        this.dateIndented = dateIndented;
        this.riskCategory = riskCategory;
        this.riskDescription = riskDescription;
        this.riskOwner = riskOwner;
        this.impact = impact;
        this.contributingFactor = contributingFactor;
        this.currentControl = currentControl;
        this.currentControlEvaluation = currentControlEvaluation;
        this.likelihood = likelihood;
        this.severity = severity;
        this.rank = rank;
        this.rankDescription = rankDescription;
        this.response = response;
        this.responsePlan = responsePlan;
        this.actualAction = actualAction;
        this.dueDate = dueDate;
        this.status = status;
    }*/

    public Date getDateIndented() {
        return dateIndented;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public String getRiskDescription() {
        return riskDescription;
    }

    public String getRiskOwner() {
        return riskOwner;
    }

    public String getImpact() {
        return impact;
    }

    public String getContributingFactor() {
        return contributingFactor;
    }

    public String getCurrentControl() {
        return currentControl;
    }

    public String getCurrentControlEvaluation() {
        return currentControlEvaluation;
    }

    public String getLikelihood() {
        return likelihood;
    }

    public String getSeverity() {
        return severity;
    }

    public int getRank() {
        return rank;
    }

    public String getRankDescription() {
        return rankDescription;
    }

    public String getResponse() {
        return response;
    }

    public String getResponsePlan() {
        return responsePlan;
    }

    public String getActualAction() {
        return actualAction;
    }

    public Date getDueDate() {
        return dueDate;
    }



    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "RiskRegister{" +
                "id='" + id + '\'' +
                ", dateIndented=" + dateIndented +
                ", riskCategory='" + riskCategory + '\'' +
                ", riskDescription='" + riskDescription + '\'' +
                ", riskOwner='" + riskOwner + '\'' +
                ", impact='" + impact + '\'' +
                ", contributingFactor='" + contributingFactor + '\'' +
                ", currentControl='" + currentControl + '\'' +
                ", currentControlEvaluation='" + currentControlEvaluation + '\'' +
                ", likelihood='" + likelihood + '\'' +
                ", severity='" + severity + '\'' +
                ", rank=" + rank +
                ", rankDescription='" + rankDescription + '\'' +
                ", response='" + response + '\'' +
                ", responsePlan='" + responsePlan + '\'' +
                ", actualAction='" + actualAction + '\'' +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public String getId() {
        return id;
    }


}
