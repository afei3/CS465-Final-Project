package com.example.sportinate.profile_creation;

import java.io.Serializable;

public class UserInfo implements Serializable {

        private String name;

        private String descrip;

        public String getName() {

            return name;

        }

        public void setName(String name) {

            this.name = name;

        }

        public String getDescrip() {

            return descrip;

        }

        public void setDescrip(String descrip) {

            this.descrip = descrip;

        }


}
