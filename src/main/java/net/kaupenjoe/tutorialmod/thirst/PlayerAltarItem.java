package net.kaupenjoe.tutorialmod.thirst;

import net.minecraft.nbt.CompoundTag;

public class PlayerAltarItem {
    private int altarLevel;
    private final int MIN_ALTAR_LEVEL = 0;
    private final int MAX_ALTAR_LEVEL = 10;

    public int getAltarLevel() {
        return altarLevel;
    }

    public void addAltarLevel(int add) {
        this.altarLevel = Math.min(altarLevel + add, MAX_ALTAR_LEVEL);
    }

    public void subThirst(int sub) {
        this.altarLevel = Math.max(altarLevel - sub, MIN_ALTAR_LEVEL);
    }

    public void copyFrom(PlayerAltarItem source) {
        this.altarLevel = source.altarLevel;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("altarLevel", altarLevel);
    }

    public void loadNBTData(CompoundTag nbt) {
        altarLevel = nbt.getInt("altarLevel");
    }
}
