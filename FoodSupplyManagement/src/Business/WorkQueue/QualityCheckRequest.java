/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author
 */
public class QualityCheckRequest extends WorkRequest {

    private String description;
    private int requestId;
    private static int count = 0;
    private Date serviceDate;
    private String serviceDateInString;

    public QualityCheckRequest() {
        count++;
        requestId = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceDateInString() {
        return serviceDateInString;
    }

    public void setServiceDateInString(String serviceDateInString) {
        this.serviceDateInString = serviceDateInString;
    }

    @Override
    public String toString() {
        return String.valueOf(this.requestId);
    }
}
