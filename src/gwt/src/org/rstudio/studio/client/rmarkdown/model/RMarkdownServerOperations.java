/*
 * RMarkdownServerOperations.java
 *
 * Copyright (C) 2009-14 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.studio.client.rmarkdown.model;

import org.rstudio.studio.client.common.crypto.CryptoServerOperations;
import org.rstudio.studio.client.server.ServerRequestCallback;
import org.rstudio.studio.client.server.Void;

import com.google.gwt.core.client.JavaScriptObject;

public interface RMarkdownServerOperations extends CryptoServerOperations
{
   void getRMarkdownContext(
            ServerRequestCallback<RMarkdownContext> requestCallback);
       
   void renderRmd(String file, int line, String format, String encoding,
                  String paramsFile, boolean asTempfile, boolean asShiny,
                  ServerRequestCallback<Boolean> requestCallback);
   
   void renderRmdSource(String source,
                        ServerRequestCallback<Boolean> requestCallback);
   
   void terminateRenderRmd(boolean normal, 
                           ServerRequestCallback<Void> requestCallback);
   
   void rmdOutputFormat(String file, 
                        String encoding, 
                        ServerRequestCallback<String> requestCallback);
   
   void convertToYAML(JavaScriptObject input, 
                      ServerRequestCallback<RmdYamlResult> requestCallback);

   void convertFromYAML(String input, 
                        ServerRequestCallback<RmdYamlData> requestCallback);

   void discoverRmdTemplates(ServerRequestCallback<Boolean> requestCallback);
   
   void createRmdFromTemplate(String filePath, 
                              String templatePath, 
                              boolean createDirectory, 
                              ServerRequestCallback<RmdCreatedTemplate> requestCallback);
   
   void getRmdTemplate(String templatePath, 
                       ServerRequestCallback<RmdTemplateContent> requestCallback);
   
   public String getApplicationURL(String pathName);
   
   void prepareForRmdChunkExecution(String id,
                                    ServerRequestCallback<Void> requestCallback);

   void getRmdOutputInfo(String target,
                ServerRequestCallback<RmdOutputInfo> resultCallback);
   
   void executeInlineChunk(String docPath, String docId, String chunkId, 
                           String options, String content, 
                           ServerRequestCallback<Void> requestCallback);
   
   void refreshChunkOutput(String docPath, String docId, String contextId,
                           String requestId, 
                           ServerRequestCallback<Void> requestCallback);
   
   void setChunkConsole(String docId, String chunkId, 
                        ServerRequestCallback<Void> requestCallback);
}
