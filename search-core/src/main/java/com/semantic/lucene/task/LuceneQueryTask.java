/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.semantic.lucene.task;

import com.semantic.ApplicationContext;
import com.semantic.eventbus.GenericEventBus;
import com.semantic.lucene.IndexManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import org.apache.lucene.search.*;

/**
 *
 * @author cplonka
 */
public class LuceneQueryTask extends SwingWorker<TopDocs, Object> {

    private static final Logger log = Logger.getLogger(LuceneQueryTask.class.getName());
    private final Query query;
    private final int maxHits = 30;
    private IndexSearcher searcher;
    /** sort by file creation date */
    public static Sort SORT = Sort.RELEVANCE;

    public LuceneQueryTask(Query query) {
        this.query = query;
    }

    @Override
    protected TopDocs doInBackground() throws Exception {
        return working();
    }
    
    private TopDocs working()throws Exception{
        IndexManager lucene = ApplicationContext.instance().getProperty(
                IndexManager.LUCENE_MANAGER);
        log.info(String.format("current search query: %s", query));
        searcher = lucene.getIndexSearcher();        
        /* index searcher - MulitCollector.wrap */
        return searcher.search(query, null, maxHits, SORT);
    }    

    @Override
    protected void done() {
        super.done();
        try {
            /* now we are back on the EDT */
            GenericEventBus.fireEvent(new QueryResultEvent(searcher, query, get()));
        } catch (Exception ex) {
            log.log(Level.WARNING, "can not execute query.", ex);
        }
    }
}