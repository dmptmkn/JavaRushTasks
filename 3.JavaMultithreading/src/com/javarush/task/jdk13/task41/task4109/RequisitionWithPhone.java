package com.javarush.task.jdk13.task41.task4109;

public abstract class RequisitionWithPhone extends RequisitionBase {

    public String phone;

    protected RequisitionWithPhone() {
    }

    protected RequisitionWithPhone(RequisitionWithPhone requisitionWithPhone) {
        super(requisitionWithPhone);
        this.phone = requisitionWithPhone.phone;
    }
}
