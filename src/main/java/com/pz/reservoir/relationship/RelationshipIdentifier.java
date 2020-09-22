package com.pz.reservoir.relationship;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@EqualsAndHashCode
public class RelationshipIdentifier {
    private final String id;

    @Override
    public String toString() {
        return id;
    }

    public static RelationshipIdentifier of(String id){
        return new RelationshipIdentifier(UUID.fromString(id).toString());
    }

    public static RelationshipIdentifier generate(){
        return new RelationshipIdentifier(UUID.randomUUID().toString());
    }


}
