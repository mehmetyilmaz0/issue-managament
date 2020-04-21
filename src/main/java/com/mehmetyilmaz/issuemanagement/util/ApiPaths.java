package com.mehmetyilmaz.issuemanagement.util;

public final class ApiPaths {

    public static final String BASE_PATH = "/api";

    public final static class IssueCtrl {
        public final static String CTRL = BASE_PATH + "/issue";
    }

    public final static class ProjectCtrl {
        public final static String CTRL = BASE_PATH + "/project";
    }

    public final static class ProjectVersioned {
        public final static String CTRL = BASE_PATH + "/project/versioning";
    }

}
