package com.ch.entity;

public class LoopLine {
    private Long id;

    private String loopLineDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoopLineDesc() {
        return loopLineDesc;
    }

    public void setLoopLineDesc(String loopLineDesc) {
        this.loopLineDesc = loopLineDesc == null ? null : loopLineDesc.trim();
    }
}