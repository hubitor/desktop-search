/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.semantic.util.test;

import com.semantic.model.OntologyNode;
import com.semantic.swing.tree.nodes.DefaultOntologyTreeNode;
import static com.semantic.util.swing.jtree.TreeExpansionState.*;

/**
 *
 * @author Christian
 */
public class ListenTreeNode<T extends OntologyNode> extends DefaultOntologyTreeNode<T> {

    public ListenTreeNode(T userData) {
        super(userData);
        initNode();
    }

    protected void initNode() {
        setChecked(getUserObject().getProperty(TREE_NODE_CHECKED));
        /* */
        int size = getUserObject().getNodeCount();
        for (int i = 0; i < size; i++) {
            addNode(new ListenTreeNode(getUserObject().getChildAt(i)));
        }
    }

    @Override
    public void setChecked(boolean value) {
        super.setChecked(value);
        /* redirect to the model, event will occur on the */
        getUserObject().setProperty(TREE_NODE_CHECKED, value);
    }

    @Override
    public boolean isChecked() {
        return getUserObject().getProperty(TREE_NODE_CHECKED);
    }
}