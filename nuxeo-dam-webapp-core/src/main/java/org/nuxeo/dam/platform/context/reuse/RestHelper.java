/*
 * (C) Copyright 2006-2007 Nuxeo SAS (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Nuxeo - initial API and implementation
 *
 * $Id: JOOoConvertPluginImpl.java 18651 2007-05-13 20:28:53Z sfermigier $
 */

package org.nuxeo.dam.platform.context.reuse;

import static org.jboss.seam.ScopeType.EVENT;
import static org.jboss.seam.annotations.Install.DEPLOYMENT;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.nuxeo.ecm.platform.ui.web.util.BaseURL;
import org.nuxeo.ecm.platform.url.api.DocumentView;

/**
 * TODO: remove RestHelper : waiting Techlead solution
 *
 * @author Benjamin JALON
 */
@Name("restHelper")
@Scope(EVENT)
@Install(precedence = DEPLOYMENT)
public class RestHelper implements Serializable {

    private static final long serialVersionUID = 1L;

    private String baseURL = "";

    private DocumentView documentView;

    @Factory(value = "baseURL", scope = ScopeType.CONVERSATION)
    public String getBaseURL() {
        if (baseURL.equals("")) {
            baseURL = BaseURL.getBaseURL();
        }
        return baseURL;
    }

    public DocumentView getDocumentView() {
        return documentView;
    }

    public void setDocumentView(DocumentView documentView) {
        this.documentView = documentView;
    }

}
