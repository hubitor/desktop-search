/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.semantic.lucene.fields;

import com.semantic.lucene.util.IFieldProperty;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;

/**
 * last modification date (datatype - long) 
 * @author Christian
 */
public class LastModifiedField implements IFieldProperty<Long> {

    public static final String NAME = "last_modified";

    @Override
    public Class<Long> getClazz() {
        return Long.class;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void add(Document doc, Long value) {
        doc.add(new LongField(getName(), value, Field.Store.YES));
    }
}