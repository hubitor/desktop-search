/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.semantic.lucene.fields.image;

import com.semantic.lucene.util.IFieldProperty;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.DoubleField;
import org.apache.lucene.document.Field;

/**
 * GPS Exif image exchange format informations
 * GPS field TAG_GPS_LATITUDE in decimal degree (datatype - double)
 *
 * @author Christian
 */
public class LatField implements IFieldProperty<Double> {

    public static final String NAME = "image_exif_gps_lat";

    @Override
    public Class<Double> getClazz() {
        return Double.class;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void add(Document doc, Double value) {
        doc.add(new DoubleField(getName(), value, Field.Store.YES));
    }
}