package com.eyallupu.blog.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eyallupu.blog.springmvc.services.CreditService;

public class AsyncServlet extends HttpServlet {

	/**
	 * SUID
	 */
	private static final long serialVersionUID = 7764336438924868118L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AsyncContext asyncCtx = req.startAsync();
		asyncCtx.start(new GetBalanceTask(asyncCtx));
	}

	private static class GetBalanceTask implements Runnable {

		final private AsyncContext asyncContext;

		GetBalanceTask(AsyncContext asyncContext) {
			this.asyncContext = asyncContext;
		}

		@Override
		public void run() {
			try {
				long balance = CreditService.instance.getBalance(null);
				asyncContext.getResponse().getWriter().format("{ balance : '%d'}", balance);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Request failed", e);
			} finally {
				asyncContext.complete();
			}
		}

	}
}
