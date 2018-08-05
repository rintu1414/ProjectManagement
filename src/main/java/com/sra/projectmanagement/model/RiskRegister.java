package com.sra.projectmanagement.model;
import com.sra.projectmanagement.utils.Identifiable;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RISK_REGISTER")
@EntityListeners(AuditingEntityListener.class)
public class RiskRegister implements Serializable, Identifiable<String>{

    @Id
    @GeneratedValue(
            generator = "assigned-sequence",
            strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "assigned-sequence",
            strategy = "com.sra.projectmanagement.utils.StringSequenceIdentifier"
    )

    @Column(name = "risk_id",nullable = false)
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

    public Date getDateIndented() {
        return dateIndented;
    }

    public void setDateIndented(Date dateIndented) {
        this.dateIndented = dateIndented;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getRiskDescription() {
        return riskDescription;
    }

    public void setRiskDescription(String riskDescription) {
        this.riskDescription = riskDescription;
    }

    public String getRiskOwner() {
        return riskOwner;
    }

    public void setRiskOwner(String riskOwner) {
        this.riskOwner = riskOwner;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getContributingFactor() {
        return contributingFactor;
    }

    public void setContributingFactor(String contributingFactor) {
        this.contributingFactor = contributingFactor;
    }

    public String getCurrentControl() {
        return currentControl;
    }

    public void setCurrentControl(String currentControl) {
        this.currentControl = currentControl;
    }

    public String getCurrentControlEvaluation() {
        return currentControlEvaluation;
    }

    public void setCurrentControlEvaluation(String currentControlEvaluation) {
        this.currentControlEvaluation = currentControlEvaluation;
    }

    public String getLikelihood() {
        return likelihood;
    }

    public void setLikelihood(String likelihood) {
        this.likelihood = likelihood;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getRankDescription() {
        return rankDescription;
    }

    public void setRankDescription(String rankDescription) {
        this.rankDescription = rankDescription;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponsePlan() {
        return responsePlan;
    }

    public void setResponsePlan(String responsePlan) {
        this.responsePlan = responsePlan;
    }

    public String getActualAction() {
        return actualAction;
    }

    public void setActualAction(String actualAction) {
        this.actualAction = actualAction;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getId() {
        return id;
    }
}
