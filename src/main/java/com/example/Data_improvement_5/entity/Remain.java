package com.example.Data_improvement_5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*用户钱包里的余额*/

public class Remain {
    @Entity
    @Table(name = "Remain_Inf")
    public class User {
        @Id
        private String id;
        @Column(length = 50)
        private double reamin;
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getReamin() {
            return reamin;
        }

        public void setReamin(double reamin) {
            this.reamin = reamin;
        }


    }
}
