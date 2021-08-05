package tests.builder;

public class MilestoneBuilder {
    String name;
    String password;
    String milestoneName;
    String milestoneDescription;

    public MilestoneBuilder(Builder builder) {
        this.name = builder.name;
        this.password = builder.password;
        this.milestoneName = builder.milestoneName;
        this.milestoneDescription = builder.milestoneDescription;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public String getMilestoneDescription() {
        return milestoneDescription;
    }

    public String getUsername() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public static final class Builder {
        private String name;
        private String password;
        private String milestoneName;
        private String milestoneDescription;

        public Builder() {
        }

        public Builder(MilestoneBuilder origin) {
            this.name = origin.name;
            this.password = origin.password;
            this.milestoneName = origin.milestoneName;
            this.milestoneDescription = origin.milestoneDescription;
        }

        public Builder withUsername(String name) {
            this.name = name;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withMileStoneName(String milestoneName) {
            this.milestoneName = milestoneName;
            return this;
        }

        public Builder withMileStoneDescription(String milestoneDescription) {
            this.milestoneDescription = milestoneName;
            return this;
        }


        public MilestoneBuilder build() {
            return new MilestoneBuilder(this);
        }
    }

}
