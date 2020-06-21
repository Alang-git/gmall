package com.bjpowernode.gmall.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * ClassName:PmsBaseCatalog3
 * Package:com.bjpowernode.gmall.bean
 * Description:
 *
 * @date:2020/2/12 0:10)
 * @author:Lan
 */
public class PmsBaseCatalog3 implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;
    @Column
    private String catalog2Id;

    @Transient
    private List<PmsBaseCatalog1> catalog1s;
    @Transient
    private List<PmsBaseCatalog2> catalog2s;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(String catalog2Id) {
        this.catalog2Id = catalog2Id;
    }
}
