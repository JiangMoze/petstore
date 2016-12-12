<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

	<%@include file="../commons/top.jsp" %>

		<table border="0" cellspacing="2" cellpadding="0" width="100%">
			<tr>
				<td valign="top" width="100%">

					<table align="left" border="0" cellspacing="0" width="80%">
						<tbody>
							<tr>
								<td valign="top">

									<!-- SIDEBAR -->
									
									<table bgcolor="#5A8C29" border="0" cellspacing="2"
										cellpadding="0" width="100%">
										<tr>
											<td>
												<table bgcolor="#FFFF88" border="0" cellspacing="0"
													cellpadding="5" width="200">
													<tbody>
														<tr>
															<td>
																<%
																	if(session.getAttribute("xm")!=null){
																 %>
															
																<b><i><font size="2" color="BLACK">欢迎<%=session.getAttribute("xm") %></font></i></b>
																<%	
																	}
																	else{
																	
																	
																	}
																
																 %>
																&nbsp;
															</td>
														</tr>
														<tr>
															<td>
															<a href="viewCategory.xhtml?category=Fish"><img
																		border="0" src="../images/fish_icon.gif" /></a>
															
																
																<br>
																<font size="2"><i>咸水鱼、淡水鱼类</i>
																</font>
															</td>
														</tr>
														<tr>
															<td>
																<a
																	href="viewCategory.xhtml?category=Dogs"><img
																		border="0" src="../images/dogs_icon.gif" />
																</a>
																<br>
																<font size="2"><i>多品种</i>
																</font>
															</td>
														</tr>
														<tr>
															<td>
																<a
																	href="viewCategory.xhtml?category=Cats"><img
																		border="0" src="../images/cats_icon.gif" />
																</a>
																<br>
																<font size="2"><i>多品种，国外品种</i>
																</font>
															</td>
														</tr>
														<tr>
															<td>
																<a
																	href="viewCategory.xhtml?category=Reptiles"><img
																		border="0" src="../images/reptiles_icon.gif" />
																</a>
																<br>
																<font size="2"><i>蜥蜴 乌龟 蛇</i>
																</font>
															</td>
														</tr>
														<tr>
															<td>
																<a
																	href="viewCategory.xhtml?category=Birds"><img
																		border="0" src="../images/birds_icon.gif" />
																</a>
																<br>
																<font size="2"><i>各种奇异的品种</i>
																</font>
															</td>
														</tr>

													</tbody>
												</table>
											</td>
										</tr>
									</table>

								</td>
								<td align="center" bgcolor="white" height="300" width="100%">

									<!-- MAIN IMAGE -->

									<map name="estoremap">
										<area alt="Birds" coords="72,2,280,250"
											href="viewCategory.xhtml?category=Birds" shape="RECT" />
										<area alt="Fish" coords="2,180,72,250"
											href="viewCategory.xhtml?category=Fish" shape="RECT" />
										<area alt="Dogs" coords="60,250,130,320"
											href="viewCategory.xhtml?category=DOGS" shape="RECT" />
										<area alt="Reptiles" coords="140,270,210,340"
											href="viewCategory.xhtml?category=REPTILES" shape="RECT" />
										<area alt="Cats" coords="225,240,295,310"
											href="viewCategory.xhtml?category=CATS" shape="RECT" />
										<area alt="Birds" coords="280,180,350,250"
											href="viewCategory.xhtml?category=BIRDS" shape="RECT" />
									</map>
									<img border="0" height="355" src="../images/splash.gif"
										align="center" usemap="#estoremap" width="350" />
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>

		</table>

		<br>
<%@include file="../commons/banner.jsp" %>		
<%@include file="../commons/bottom.jsp" %>

