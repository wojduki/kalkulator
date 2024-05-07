package com.wojduki.kalkulator.repository;

import java.util.List;

public class SelectedMaterialsHolder {

    private List<Integer> floorId;
    private List<Integer> wallsId;
    private List<Integer> ceilingId;

    public SelectedMaterialsHolder() {
    }

    public SelectedMaterialsHolder(List<Integer> floorId, List<Integer> wallsId, List<Integer> ceilingId) {
        this.floorId = floorId;
        this.wallsId = wallsId;
        this.ceilingId = ceilingId;
    }

    public List<Integer> getFloorId() {
        return floorId;
    }

    public void setFloorId(List<Integer> floorId) {
        this.floorId = floorId;
    }

    public List<Integer> getWallsId() {
        return wallsId;
    }

    public void setWallsId(List<Integer> wallsId) {
        this.wallsId = wallsId;
    }

    public List<Integer> getCeilingId() {
        return ceilingId;
    }

    public void setCeilingId(List<Integer> ceilingId) {
        this.ceilingId = ceilingId;
    }
}
