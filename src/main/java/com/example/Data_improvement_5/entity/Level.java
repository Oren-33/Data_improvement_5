package com.example.Data_improvement_5.entity;

import javax
        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
    /*用于表明用户的等级*/
    public class Level {
        @Entity
        @Table(name = "Level_Inf")
        public class User {
            @Id
            private String id;
            @Column(length = 50)
            private int level;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

        }
