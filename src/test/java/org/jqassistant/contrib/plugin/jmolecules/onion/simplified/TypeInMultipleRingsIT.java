package org.jqassistant.contrib.plugin.jmolecules.onion.simplified;

import com.buschmais.jqassistant.core.report.api.model.Result;
import com.buschmais.jqassistant.core.rule.api.model.Constraint;
import com.buschmais.jqassistant.core.rule.api.model.RuleException;
import com.buschmais.jqassistant.plugin.java.test.AbstractJavaPluginIT;
import org.jqassistant.contrib.plugin.jmolecules.set.violation.ring1.SimplifiedRing;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeInMultipleRingsIT extends AbstractJavaPluginIT {

    @Test
    public void testTypeInMultipleBoundedContexts() throws RuleException {
        scanClassPathDirectory(getClassesDirectory(SimplifiedRing.class));
        Result<Constraint> result = validateConstraint("jmolecules-onion-simplified:TypeInMultipleRings");
        assertEquals(1, result.getRows().size());
        Map<String, Object> row = result.getRows().get(0);
        assertEquals("org.jqassistant.contrib.plugin.jmolecules.set.violation.ring1.SimplifiedRing", row.get("Type"));
    }
}
