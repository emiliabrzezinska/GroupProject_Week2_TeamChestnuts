package org.kainos.ea;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class DropWizardAppApplication extends Application<DropWizardAppConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardAppApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropWizardApp";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardAppConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropWizardAppConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
