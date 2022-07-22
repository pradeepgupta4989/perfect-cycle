package com.alraedah.perfectcycle.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Node {
    int index;
    int value;
}