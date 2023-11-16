/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2023 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.126.0Release
// Tag = production/release/21.126.0-0-g0576dfe
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;

import java.io.OutputStream;

public class FieldDefinition extends FieldDefinitionBase {
    protected int num;
    protected int size;
    protected int type;

    protected FieldDefinition() {
        num = Fit.FIELD_NUM_INVALID;
        size = 0;
    }

    public FieldDefinition(Field field) {
        num = field.getNum();
        size = field.getSize();
        type = field.getType();
    }

    protected void write(OutputStream out) {
        try {
            out.write(num);
            out.write(size);
            out.write(type);
        } catch (java.io.IOException e) {
        }
    }

    public int getNum() {
        return num;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getType() {
        return type;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof FieldDefinition)) {
            return false;
        }

        FieldDefinition other = (FieldDefinition)o;

        if (num != other.num) {
            return false;
        }

        if (size != other.size) {
            return false;
        }

        if (type != other.type) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int hashCode = 1;

        hashCode = (hashCode * 47) + new Integer(this.num).hashCode();
        hashCode = (hashCode * 31) + new Integer(this.size).hashCode();
        hashCode = (hashCode * 19) + new Integer(this.type).hashCode();

        return hashCode;
    }
}
