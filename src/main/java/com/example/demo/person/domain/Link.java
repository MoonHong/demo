package com.example.demo.person.domain;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-17.
 */
public class Link {


    /**
     *主键
     */
    private Long id;


    /**
     * 联系电话
     */
    private String phone;


    /**
     * 联系地址
     *
     */
    private String address;

    /**
     * qq
     *
     */
    private String QQ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }


    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", QQ='" + QQ + '\'' +
                '}';
    }
}
