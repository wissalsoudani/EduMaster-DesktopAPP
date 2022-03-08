/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Test_histoire {

    private int id_test;
    private int id_histoire;
    private String question1;
    private String R11;
    private String R12;
    private String R13;
    private String correctionQ1;
    private String question2;
    private String R21;
    private String R22;
    private String R23;
    private String correctionQ2;
    private String question3;
    private String R31;
    private String R32;
    private String R33;
    private String correctionQ3;

    public Test_histoire() {
    }

    public Test_histoire(int id_test, int id_histoire, String question1, String R11, String R12, String R13, String correctionQ1, String question2, String R21, String R22, String R23, String correctionQ2, String question3, String R31, String R32, String R33, String correctionQ3) {
        this.id_test = id_test;
        this.id_histoire = id_histoire;
        this.question1 = question1;
        this.R11 = R11;
        this.R12 = R12;
        this.R13 = R13;
        this.correctionQ1 = correctionQ1;
        this.question2 = question2;
        this.R21 = R21;
        this.R22 = R22;
        this.R23 = R23;
        this.correctionQ2 = correctionQ2;
        this.question3 = question3;
        this.R31 = R31;
        this.R32 = R32;
        this.R33 = R33;
        this.correctionQ3 = correctionQ3;
    }

    public Test_histoire(int id_histoire, String question1, String R11, String R12, String R13, String correctionQ1, String question2, String R21, String R22, String R23, String correctionQ2, String question3, String R31, String R32, String R33, String correctionQ3) {
        this.id_histoire = id_histoire;
        this.question1 = question1;
        this.R11 = R11;
        this.R12 = R12;
        this.R13 = R13;
        this.correctionQ1 = correctionQ1;
        this.question2 = question2;
        this.R21 = R21;
        this.R22 = R22;
        this.R23 = R23;
        this.correctionQ2 = correctionQ2;
        this.question3 = question3;
        this.R31 = R31;
        this.R32 = R32;
        this.R33 = R33;
        this.correctionQ3 = correctionQ3;
    }

    public int getId_test() {
        return id_test;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public int getId_histoire() {
        return id_histoire;
    }

    public void setId_histoire(int id_histoire) {
        this.id_histoire = id_histoire;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getR11() {
        return R11;
    }

    public void setR11(String R11) {
        this.R11 = R11;
    }

    public String getR12() {
        return R12;
    }

    public void setR12(String R12) {
        this.R12 = R12;
    }

    public String getR13() {
        return R13;
    }

    public void setR13(String R13) {
        this.R13 = R13;
    }

    public String getCorrectionQ1() {
        return correctionQ1;
    }

    public void setCorrectionQ1(String correctionQ1) {
        this.correctionQ1 = correctionQ1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getR21() {
        return R21;
    }

    public void setR21(String R21) {
        this.R21 = R21;
    }

    public String getR22() {
        return R22;
    }

    public void setR22(String R22) {
        this.R22 = R22;
    }

    public String getR23() {
        return R23;
    }

    public void setR23(String R23) {
        this.R23 = R23;
    }

    public String getCorrectionQ2() {
        return correctionQ2;
    }

    public void setCorrectionQ2(String correctionQ2) {
        this.correctionQ2 = correctionQ2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getR31() {
        return R31;
    }

    public void setR31(String R31) {
        this.R31 = R31;
    }

    public String getR32() {
        return R32;
    }

    public void setR32(String R32) {
        this.R32 = R32;
    }

    public String getR33() {
        return R33;
    }

    public void setR33(String R33) {
        this.R33 = R33;
    }

    public String getCorrectionQ3() {
        return correctionQ3;
    }

    public void setCorrectionQ3(String correctionQ3) {
        this.correctionQ3 = correctionQ3;
    }

    @Override
    public String toString() {
        return "Test_histoire{" + "id_test=" + id_test + ", id_histoire=" + id_histoire + ", question1=" + question1 + ", R11=" + R11 + ", R12=" + R12 + ", R13=" + R13 + ", correctionQ1=" + correctionQ1 + ", question2=" + question2 + ", R21=" + R21 + ", R22=" + R22 + ", R23=" + R23 + ", correctionQ2=" + correctionQ2 + ", question3=" + question3 + ", R31=" + R31 + ", R32=" + R32 + ", R33=" + R33 + ", correctionQ3=" + correctionQ3 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id_test;
        hash = 19 * hash + this.id_histoire;
        hash = 19 * hash + Objects.hashCode(this.question1);
        hash = 19 * hash + Objects.hashCode(this.R11);
        hash = 19 * hash + Objects.hashCode(this.R12);
        hash = 19 * hash + Objects.hashCode(this.R13);
        hash = 19 * hash + Objects.hashCode(this.correctionQ1);
        hash = 19 * hash + Objects.hashCode(this.question2);
        hash = 19 * hash + Objects.hashCode(this.R21);
        hash = 19 * hash + Objects.hashCode(this.R22);
        hash = 19 * hash + Objects.hashCode(this.R23);
        hash = 19 * hash + Objects.hashCode(this.correctionQ2);
        hash = 19 * hash + Objects.hashCode(this.question3);
        hash = 19 * hash + Objects.hashCode(this.R31);
        hash = 19 * hash + Objects.hashCode(this.R32);
        hash = 19 * hash + Objects.hashCode(this.R33);
        hash = 19 * hash + Objects.hashCode(this.correctionQ3);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Test_histoire other = (Test_histoire) obj;
        if (this.id_test != other.id_test) {
            return false;
        }
        if (this.id_histoire != other.id_histoire) {
            return false;
        }
        if (!Objects.equals(this.question1, other.question1)) {
            return false;
        }
        if (!Objects.equals(this.R11, other.R11)) {
            return false;
        }
        if (!Objects.equals(this.R12, other.R12)) {
            return false;
        }
        if (!Objects.equals(this.R13, other.R13)) {
            return false;
        }
        if (!Objects.equals(this.correctionQ1, other.correctionQ1)) {
            return false;
        }
        if (!Objects.equals(this.question2, other.question2)) {
            return false;
        }
        if (!Objects.equals(this.R21, other.R21)) {
            return false;
        }
        if (!Objects.equals(this.R22, other.R22)) {
            return false;
        }
        if (!Objects.equals(this.R23, other.R23)) {
            return false;
        }
        if (!Objects.equals(this.correctionQ2, other.correctionQ2)) {
            return false;
        }
        if (!Objects.equals(this.question3, other.question3)) {
            return false;
        }
        if (!Objects.equals(this.R31, other.R31)) {
            return false;
        }
        if (!Objects.equals(this.R32, other.R32)) {
            return false;
        }
        if (!Objects.equals(this.R33, other.R33)) {
            return false;
        }
        if (!Objects.equals(this.correctionQ3, other.correctionQ3)) {
            return false;
        }
        return true;
    }

}
