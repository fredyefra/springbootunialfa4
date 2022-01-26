package br.com.loccar.security;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig  {

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET,
	 * "/").permitAll() .anyRequest() .authenticated() .and() .formLogin()
	 * .permitAll() .and() .logout() .logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout")); }
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("aluno").password("123").roles("ADMIN"
	 * ); }
	 * 
	 * @Override public void configure(WebSecurity security) throws Exception {
	 * security.ignoring().antMatchers("/materialize/**","/style/**"); }
	 */
}
