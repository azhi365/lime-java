/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.proxy.star;

import org.junit.Test;

import org.walnuts.study.dp.example.structure.adapter.star.IActor;
import org.walnuts.study.dp.example.structure.adapter.star.Standin;
import org.walnuts.study.dp.example.structure.adapter.star.UnknownActor;
import org.walnuts.study.dp.example.structure.bridge.star.AbsStar;
import org.walnuts.study.dp.example.structure.bridge.star.ActFilm;
import org.walnuts.study.dp.example.structure.bridge.star.Singer;
import org.walnuts.study.dp.example.structure.decorator.star.Deny;
import org.walnuts.study.dp.example.structure.decorator.star.FreakStar;
import org.walnuts.study.dp.example.structure.decorator.star.HotAir;

/**
 * 包装模式:装饰模式、适配器模式、门面模式、代理模式、桥梁模式
 * @author YZhi
 * @since 1.0
 */
public class StarClient {
	/**
	 * 代理模式
	 */
	@Test
	public void testStarProxy(){
		IStar star = new Star();
		IStar agent = new Agent(star);
		agent.act();
	}
	
	/**
	 * 装饰模式
	 */
	@Test
	public void testStarDecorator(){
		IStar freackStar = new FreakStar();
		freackStar.act();
		freackStar = new HotAir(freackStar);
		freackStar.act();
		freackStar = new Deny(freackStar);
		freackStar.act();
	}
	
	/**
	 * 适配器模式
	 */
	@Test
	public void testStarAdpter(){
		IStar star = new org.walnuts.study.dp.example.structure.adapter.star.FilmStar();
		star.act();
		IActor actor = new UnknownActor();
		IStar standin = new Standin(actor);
		standin.act();
		star.act();
	}
	
	/**
	 * 桥梁模式
	 */
	@Test
	public void testStarBriadge(){
/*		AbsStar zhangSan = new FilmStar();
		AbsStar lisi = new Singer();
		zhangSan.doJob();
		lisi.doJob();
		lisi = new Singer(new ActFilm());
		lisi.doJob();*/
	}
	
	
}
