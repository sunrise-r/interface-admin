package com.iadmin.ui.service.inheritance;

import com.iadmin.ui.model.BaseProjection;

/**
 * Applay Inheritance Strategy to Projection
 */
public interface InheritanceStrategy {

    /**
     *  Inherite values from @parentProjection to @child projection
     * @param child Child projection
     * @param parentProjection Parent Projection
     */
    void applyTo(BaseProjection child, BaseProjection parentProjection);
}
