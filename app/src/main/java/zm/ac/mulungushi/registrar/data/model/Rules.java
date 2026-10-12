package zm.ac.mulungushi.registrar.data.model;

/** Shared business rules and reference data (the real limit is enforced by the server). */
public final class Rules {
    private Rules() {}

    public static final int CAPACITY = 15;
    public static final String[] PROGRAMMES = {"CS", "IT", "DS"};
    public static final String[] GROUPS = {"G01", "G02", "G03", "G04"};
    public static final String UNASSIGNED = "Unassigned";
    public static final String DEMO_NUMBER_FALLBACK = "202301045";
}
