#!/bin/sh
scala -cp target/scala-2.10/wartremover-example-println_2.10-0.1-SNAPSHOT.jar \
      ~/.ivy2/local/org.brianmckenna/wartremover_2.10/0.8-SNAPSHOT/jars/wartremover_2.10.jar \
      -traverser org.brianmckenna.nescala.warts.Println \
      $@
