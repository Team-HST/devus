package com.hst.devus.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@Setter
@ConfigurationProperties("app")
public class ApplicationProperties {
	private Security security;

	@Data
	public static class Security {
		private PublicPaths publicPaths;
		private String tokenSecret;
		private Long tokenExpirationMs;

		@Data
		public static class PublicPaths {
			private List<String> defaults;
			private List<String> optionals;

			public List<String> getMergedPublicPaths() {
				List<String> publicPaths = new ArrayList<>(defaults);
				if (optionals != null && !optionals.isEmpty()) {
					publicPaths.addAll(optionals);
				}
				return publicPaths;
			}
		}
	}
}
