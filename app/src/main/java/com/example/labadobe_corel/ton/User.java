package com.example.labadobe_corel.ton;

/**
 * Created by Lab. Adobe_Corel on 21/06/2017.
 */

public class User {

    public String idUser;
    public String fristName, lastName, email, rg, cpf,phone,cellphone, andress, cep, passoword, provaider;

    public User() {

    }


    public User(String id, String fristName, String lastName, String email, String rg, String cpf, String phone, String cellphone, String andress, String cep, String passoword, String provaider ){
        this.idUser = id;
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.phone = phone;
        this.cellphone = cellphone;
        this.andress = andress;
        this.cep = cep;
        this.passoword = passoword;
        this.provaider = provaider;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAndress() {
        return andress;
    }

    public void setAndress(String andress) {
        this.andress = andress;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {
        this.passoword = passoword;
    }

    public String getProvaider() {
        return provaider;
    }

    public void setProvaider(String provaider) {
        this.provaider = provaider;
    }


}