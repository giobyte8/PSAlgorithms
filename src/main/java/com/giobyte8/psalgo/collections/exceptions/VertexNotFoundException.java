package com.giobyte8.psalgo.collections.exceptions;

public class VertexNotFoundException extends RuntimeException {

    public VertexNotFoundException(String nodeValue) {
        super(String.format(
                "Vertex '%s' not found in graph",
                nodeValue
        ));
    }
}
