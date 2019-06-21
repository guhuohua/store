package com.ch.service;

import com.ch.dto.SolrDTO;

/**
 * 同步solr
 */
public interface SolrService {

    void addSolr(SolrDTO solrDTO);

      void lowerShelf(SolrDTO solrDTO);

}
