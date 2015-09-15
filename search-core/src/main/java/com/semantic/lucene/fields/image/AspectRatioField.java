/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.semantic.lucene.fields.image;

import com.semantic.lucene.util.IFieldProperty;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FloatField;

/**
 * image aspect ration (width/height) (datatype - float)
 * @author Christian
 */
public class AspectRatioField implements IFieldProperty<Float> {

    public static final String NAME = "image_aspect_ratio";

    @Override
    public Class<Float> getClazz() {
        return Float.class;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void add(Document doc, Float value) {
        doc.add(new FloatField(getName(), value, Field.Store.YES));
    }
}