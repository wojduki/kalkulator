package com.wojduki.kalkulator.repository;

import java.util.List;

public class SelectedItemsHolder {

    private List<Integer> floorItemsIds;
    private List<Integer> wallsItemsIds;
    private List<Integer> ceilingItemsIds;

    public SelectedItemsHolder() {
    }

    public SelectedItemsHolder(List<Integer> floorItemsIds, List<Integer> wallsItemsIds, List<Integer> ceilingItemsIds) {
        this.floorItemsIds = floorItemsIds;
        this.wallsItemsIds = wallsItemsIds;
        this.ceilingItemsIds = ceilingItemsIds;
    }

    public List<Integer> getFloorItemsIds() {
        return floorItemsIds;
    }

    public void setFloorItemsIds(List<Integer> floorItemsIds) {
        this.floorItemsIds = floorItemsIds;
    }

    public List<Integer> getWallsItemsIds() {
        return wallsItemsIds;
    }

    public void setWallsItemsIds(List<Integer> wallsItemsIds) {
        this.wallsItemsIds = wallsItemsIds;
    }

    public List<Integer> getCeilingItemsIds() {
        return ceilingItemsIds;
    }

    public void setCeilingItemsIds(List<Integer> ceilingItemsIds) {
        this.ceilingItemsIds = ceilingItemsIds;
    }
}
