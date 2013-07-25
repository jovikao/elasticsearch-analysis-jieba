package org.elasticsearch.index.analysis.py;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;
import org.elasticsearch.index.settings.IndexSettings;


public class PyJiebaAnalyzerProvider extends AbstractIndexAnalyzerProvider<PyJiebaAnalyzer> {
  private final PyJiebaAnalyzer analyzer;

  @Inject
  public PyJiebaAnalyzerProvider(Index index, @IndexSettings Settings indexSettings, Environment env,
      @Assisted String name, @Assisted Settings settings) {
    super(index, indexSettings, name, settings);
    analyzer = new PyJiebaAnalyzer(indexSettings, settings);
  }

  @Override
  public PyJiebaAnalyzer get() {
    return this.analyzer;
  }
}
