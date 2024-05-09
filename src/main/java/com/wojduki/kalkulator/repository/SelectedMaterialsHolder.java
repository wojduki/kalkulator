package com.wojduki.kalkulator.repository;

import java.util.List;

public class SelectedMaterialsHolder {

    private List<Integer> floorMaterialsIds;
    private List<Integer> wallsMaterialsIds;
    private List<Integer> ceilingMaterialsIds;

    public SelectedMaterialsHolder() {
    }

    public SelectedMaterialsHolder(List<Integer> floorMaterialsIds, List<Integer> wallsMaterialsIds, List<Integer> ceilingMaterialsIds) {
        this.floorMaterialsIds = floorMaterialsIds;
        this.wallsMaterialsIds = wallsMaterialsIds;
        this.ceilingMaterialsIds = ceilingMaterialsIds;
    }

    public List<Integer> getFloorMaterialsIds() {
        return floorMaterialsIds;
    }

    public void setFloorMaterialsIds(List<Integer> floorMaterialsIds) {
        this.floorMaterialsIds = floorMaterialsIds;
    }

    public List<Integer> getWallsMaterialsIds() {
        return wallsMaterialsIds;
    }

    public void setWallsMaterialsIds(List<Integer> wallsMaterialsIds) {
        this.wallsMaterialsIds = wallsMaterialsIds;
    }

    public List<Integer> getCeilingMaterialsIds() {
        return ceilingMaterialsIds;
    }

    public void setCeilingMaterialsIds(List<Integer> ceilingMaterialsIds) {
        this.ceilingMaterialsIds = ceilingMaterialsIds;
    }
}
