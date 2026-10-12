package zm.ac.mulungushi.registrar.data.model;

public class RequestRecord {
        public static final String GROUP = "group";
        public static final String NUMBER = "number";
        public static final String APPROVED = "approved";
        public static final String DECLINED = "declined";

        public int seq;
        public String studentId;
        public String studentName;
        public String studentNumber;
        public String kind;        // group | number
        public String from;
        public String to;
        public String reason;      // number corrections only, may be null
        public String requestedOn;
        public String status;      // approved | declined
}
