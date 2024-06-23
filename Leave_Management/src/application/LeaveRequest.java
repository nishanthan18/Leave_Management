package application;

import java.time.LocalDate;
import javafx.beans.property.*;

public class LeaveRequest {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty sNo = new SimpleIntegerProperty();
    private final StringProperty employeeId = new SimpleStringProperty();
    private final StringProperty employeeName = new SimpleStringProperty();
    private final StringProperty leaveReason = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> leaveDate = new SimpleObjectProperty<>();

    // Constructors, getters, setters for other properties

    // id property
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    // sNo property
    public int getSNo() {
        return sNo.get();
    }

    public void setSNo(int sNo) {
        this.sNo.set(sNo);
    }

    public IntegerProperty sNoProperty() {
        return sNo;
    }

    // employeeId property
    public String getEmployeeId() {
        return employeeId.get();
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId.set(employeeId);
    }

    public StringProperty employeeIdProperty() {
        return employeeId;
    }

    // employeeName property
    public String getEmployeeName() {
        return employeeName.get();
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName.set(employeeName);
    }

    public StringProperty employeeNameProperty() {
        return employeeName;
    }

    // leaveReason property
    public String getLeaveReason() {
        return leaveReason.get();
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason.set(leaveReason);
    }

    public StringProperty leaveReasonProperty() {
        return leaveReason;
    }

    // leaveDate property
    public LocalDate getLeaveDate() {
        return leaveDate.get();
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate.set(leaveDate);
    }

    public ObjectProperty<LocalDate> leaveDateProperty() {
        return leaveDate;
    }

    // Constructor using all properties
 // Constructor using all properties
    public LeaveRequest(int id, int sNo, String employeeId, String employeeName, String leaveReason, LocalDate leaveDate) {
        setId(id);
        setSNo(sNo);
        setEmployeeId(employeeId);
        setEmployeeName(employeeName);
        setLeaveReason(leaveReason);
        setLeaveDate(leaveDate);
    }

}
