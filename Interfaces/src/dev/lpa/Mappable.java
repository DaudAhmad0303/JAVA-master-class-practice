package dev.lpa;

enum Geometry {LINE, POINT, POLYGON}
enum Color {BLACK, BLUE, GREEN, ORANGE, RED}
enum PointMarker {CIRCLE, PUSH_PIM, STAR, SQUARE, TRIANGLE}
enum LineMarker {DASHED, DOTTED, SOLID}
public interface Mappable {
    String JSON_PROPERTY = """
            "properties": {%s} """;

    static void mapIt(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }

    String getLabel();
    Geometry getShape();
    String getMarker();
    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s" """
                .formatted(getShape(), getLabel(), getMarker());
    }

}
