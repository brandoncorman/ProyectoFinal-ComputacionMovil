package com.example.proyectofinal.Model;

import java.util.List;

public class Data {

    private String uuid;
    private String displayName;
    private String description;
    private String developerName;
    private List<String> characterTags;
    private String displayIcon;
    private String displayIconSmall;
    private String bustPortrait;
    private String fullPortrait;
    private String fullPortraitV2;
    private String killfeedPortrait;
    private String background;
    private List<String> backgroundGradientColors;
    private String assetPath;
    private boolean isFullPortraitRightFacing;
    private boolean isPlayableCharacter;
    private boolean isAvailableForTest;
    private boolean isBaseContent;
    private Role role;
    private List<Abilities> abilities;
    private VoiceLine voiceLine;

    public String getUuid() {
        return uuid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public List<String> isCharacterTags() {
        return characterTags;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public String getDisplayIconSmall() {
        return displayIconSmall;
    }

    public String getBustPortrait() {
        return bustPortrait;
    }

    public String getFullPortrait() {
        return fullPortrait;
    }

    public String getFullPortraitV2() {
        return fullPortraitV2;
    }

    public String getKillfeedPortrait() {
        return killfeedPortrait;
    }

    public String getBackground() {
        return background;
    }

    public List<String> getBackgroundGradientColors() {
        return backgroundGradientColors;
    }

    public String getAssetPath() {
        return assetPath;
    }

    public boolean isFullPortraitRightFacing() {
        return isFullPortraitRightFacing;
    }

    public boolean isPlayableCharacter() {
        return isPlayableCharacter;
    }

    public boolean isAvailableForTest() {
        return isAvailableForTest;
    }

    public boolean isBaseContent() {
        return isBaseContent;
    }

    public Role getRole() {
        return role;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public VoiceLine getVoiceLine() {
        return voiceLine;
    }
}
