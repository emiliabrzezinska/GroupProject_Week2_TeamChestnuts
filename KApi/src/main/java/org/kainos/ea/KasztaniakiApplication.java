package org.kainos.ea;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class KasztaniakiApplication extends Application<KasztaniakiConfiguration> {

    public static void main(final String[] args) throws Exception {
        new KasztaniakiApplication().run(args);
    }

    @Override
    public String getName() {
        return "Kasztaniaki";
    }

    @Override
    public void initialize(final Bootstrap<KasztaniakiConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final KasztaniakiConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
