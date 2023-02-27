package com.elleinfo.game.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameFilter {
    private String name;
    private String aliases;
    private String platforms;

    public static class Builder {
        private String name;
        private String aliases;
        private String platforms;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAliases(String aliases) {
            this.aliases = aliases;
            return this;
        }

        public Builder setPlatforms(String platforms) {
            this.platforms = platforms;
            return this;
        }

        public GameFilter build() {
            GameFilter gameFilter = new GameFilter();
            gameFilter.name = this.name;
            gameFilter.aliases = this.aliases;
            gameFilter.platforms = this.platforms;
            return gameFilter;
        }
    }

    public GameFilter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Map<String, List<String>> toMap() {
        Map<String, List<String>> map = new HashMap<>();
        if (platforms != null && !platforms.isEmpty())
            map.put("platforms", Arrays.asList(platforms));
        if (name != null && !name.isEmpty())
            map.put("name", Arrays.asList(name));
        if (aliases != null && !aliases.isEmpty())
            map.put("aliases", Arrays.asList(aliases));
        return map;
    }
}
