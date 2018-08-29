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

    private String sourceReference;

    private String crossReference;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String riskCategory;

    private String riskDescription;

    private String pic;

    private String impact;

    private String likelihood;

    private String severity;

    private String response;

    private String responsePlan;

    @Temporal(TemporalType.DATE)
    private Date targetDate;

    private String addToDo;

    private String status;

    private String convertToIssue;

    private double cost;

    private String currency;

    private String schedule;

    private String duration;

    private String impactDetails;

    private int rank;

    private String derivative;



    public RiskRegister() {
    }

    public String getSourceReference() {
        return sourceReference;
    }

    public void setSourceReference(String sourceReference) {
        this.sourceReference = sourceReference;
    }

    public String getCrossReference() {
        return crossReference;
    }

    public void setCrossReference(String crossReference) {
        this.crossReference = crossReference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
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

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getAddToDo() {
        return addToDo;
    }

    public void setAddToDo(String addToDo) {
        this.addToDo = addToDo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConvertToIssue() {
        return convertToIssue;
    }

    public void setConvertToIssue(String convertToIssue) {
        this.convertToIssue = convertToIssue;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImpactDetails() {
        return impactDetails;
    }

    public void setImpactDetails(String impactDetails) {
        this.impactDetails = impactDetails;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDerivative() {
        return derivative;
    }

    public void setDerivative(String derivative) {
        this.derivative = derivative;
    }

    @Override
    public String getId() {
        return id;
    }
}
