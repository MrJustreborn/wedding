/*
 * Copyright (C) 2016 Julia Thüroff <julia.thueroff@hof-university.de>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package de.mjrb.wedding;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * filter to set the cors headers in every request
 *
 * @author Julia Thüroff
 */
public class CORSFilter implements Filter {

    private static final String ACAO = "Access-Control-Allow-Origin";
    private static final String ACAM = "Access-Control-Allow-Methods";
    private static final String ACMA = "Access-Control-Max-Age";
    private static final String ACAH = "Access-Control-Allow-Headers";

    /**
     * {@inheritDoc}
     *
     * Adds headers to the response to allow cross origin use of the API.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader(ACAO, "*");
        resp.setHeader(ACAM, "PUT, POST, GET, OPTIONS, DELETE");
        resp.setHeader(ACMA, "3600");
        resp.setHeader("Access-Control-Expose-Headers ", "count");
        resp.addHeader(ACAH, "x-requested-with");
        resp.addHeader(ACAH, "Content-Type");
        resp.addHeader(ACAH, "Authorization");
        resp.addHeader(ACAH, "Bearer");
        resp.addHeader(ACAH, "*");
        resp.addHeader("Access-Control-Expose-Headers", "count, Count, Location");
        resp.addHeader("count", "1");
        chain.doFilter(request, response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() {
        // No actions on destroy.
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
