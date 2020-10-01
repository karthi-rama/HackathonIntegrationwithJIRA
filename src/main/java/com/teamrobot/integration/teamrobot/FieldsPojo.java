package com.teamrobot.integration.teamrobot;


    public class FieldsPojo
    {
        private ProjectPojo project;

        private String summary;
        
        private String description;
        
        private String customfield_10036;

        private IssueTypePojo issuetype;

        public void setProject(ProjectPojo project){
            this.project = project;
        }
        public ProjectPojo getProject(){
            return this.project;
        }
        public void setSummary(String summary){
            this.summary = summary;
        }
        public String getSummary(){
            return this.summary;
        }
        public void setDescription(String description){
            this.description = description;
        }
        public String getDescription(){
            return this.description;
        }
        public void setIssuetype(IssueTypePojo issuetype){
            this.issuetype = issuetype;
        }
        public IssueTypePojo getIssuetype(){
            return this.issuetype;
        }
        
      //created a custom field called test steps in jira
        public void setCustomfield_10036(String customfield_10036) {
            this.customfield_10036 = customfield_10036;
        }
        public String getCustomfield_10036() {
            return customfield_10036;
        }
    
}
