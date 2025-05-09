package model;

import java.util.ArrayList;

public class Alergeno implements iModel {
    private int m_iID;
    private String m_strName;
    private String m_strDescription;

    public int getID() {
        return m_iID;
    }

    public void setID(int m_iID) {
        this.m_iID = m_iID;
    }

    public String getName() {
        return m_strName;
    }

    public void setName(String m_strName) {
        this.m_strName = m_strName;
    }

    public String getDescription() {
        return m_strDescription;
    }

    public void setDescription(String m_strDescription) {
        this.m_strDescription = m_strDescription;
    }

    public Alergeno(int m_iID, String m_strName) {
        this.m_iID = m_iID;
        this.m_strName = m_strName;
        this.m_strDescription = m_strDescription;
    }

    @Override
    public String toString() {
        return "Alergeno{" +
                "m_iID=" + m_iID +
                ", m_strName='" + m_strName + '\'' +
                ", m_strDescription='" + m_strDescription + '\'' +
                '}';
    }

    @Override
    public String fromArrayToJson(ArrayList bean) {
        return null;
    }

    @Override
    public String toArrayJson(ArrayList bean) {
        return null;
    }

    @Override
    public String toSqlWhereString() {
        return null;
    }
}
