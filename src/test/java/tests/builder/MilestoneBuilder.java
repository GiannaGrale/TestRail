package tests.builder;

public class MilestoneBuilder {
    String name;
    String password;
    String milestoneName;
    String milestoneDescription;

    private MilestoneBuilder() {
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

    public static Builder newBuilder() {
        return new MilestoneBuilder().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder withUsername(String name) {
            MilestoneBuilder.this.name = name;
            return this;
        }

        public Builder withPassword(String password) {
            MilestoneBuilder.this.password = password;
            return this;
        }

        public Builder withMileStoneName(String milestoneName) {
            MilestoneBuilder.this.milestoneName = milestoneName;
            return this;
        }

        public Builder withMileStoneDescription(String milestoneDescription) {
            MilestoneBuilder.this.milestoneDescription = milestoneName;
            return this;
        }


        public MilestoneBuilder build() {
            return MilestoneBuilder.this;
        }
    }
}
