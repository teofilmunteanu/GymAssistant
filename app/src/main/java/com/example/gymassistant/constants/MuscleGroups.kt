package com.example.gymassistant.constants

enum class MuscleGroup {
    SHOULDERS, CHEST, BACK, ARMS, CORE, LEGS
}

enum class ShoulderMuscle {
    DELTOIDS,
    ROTATOR_CUFF
}

enum class DeltoidMuscle {
    ANTERIOR_DELTOID,
    LATERAL_DELTOID,
    POSTERIOR_DELTOID
}

enum class RotatorCuffMuscle {
    SUPRASPINATUS, // Abduction
    INFRASPINATUS, // External rotation
    TERES_MINOR, // External rotation
    TERES_MAJOR, // Adduction and internal rotation
    SUBSCAPULARIS // Internal rotation
}

enum class ChestMuscle {
    CLAVICULAR_PECTORALIS_MAJOR, // Upper Chest
    STERNAL_PECTORALIS_MAJOR, // Mid Chest
    ABDOMINAL_PECTORALIS_MAJOR // Lower Chest
}

enum class BackMuscle {
    TRAPEZIUS,
    RHOMBOIDS,
    LATISSIMUS_DORSI,
    ERECTOR_SPINAE
}

enum class TrapeziusMuscle {
    TRAPEZIUS_UPPER,
    TRAPEZIUS_MIDDLE,
    TRAPEZIUS_LOWER
}

enum class LatsMuscle {
    LATISSIMUS_DORSI_UPPER, //Upper Lats: By focusing on wide-grip exercises or movements that involve shoulder abduction (like wide-grip pull-ups), you can improve the upper lat sweep, contributing to the "V-taper" look. This can make the upper part of the back look broader and more defined.
    LATISSIMUS_DORSI_LOWER, //Lower Lats: When you emphasize close-grip movements or exercises that pull the arms downward, you can enhance the lower lats, which can contribute to more depth and thickness in the lower back, making the lats look fuller from the side and back.
    LATISSIMUS_DORSI_INNER, //Outer Lats: Exercises that stretch the lats (such as dumbbell pullovers) can widen the outer portion of the latissimus dorsi, giving the back a broader, more flared appearance. This is particularly important for those seeking greater width in their back.
    LATISSIMUS_DORSI_OUTER //Inner Lats: Close-grip rows or reverse-grip pull-ups can help develop the inner part of the lats, which contributes to thickness around the spine, making the back appear denser and fuller.
}

enum class ArmMuscle {
    BICEPS,
    TRICEPS,
    FOREARM,
    BRACHIALIS
}

enum class BicepsMuscle {
    BICEPS_LONG_HEAD,
    BICEPS_SHORT_HEAD
}

enum class TricepsMuscle {
    TRICEPS_LONG_HEAD,
    TRICEPS_LATERAL_HEAD,
    TRICEPS_MEDIAL_HEAD,
}

enum class ForearmMuscle {
    FOREARM_FLEXORS,
    FOREARM_EXTENSORS,
}

enum class CoreMuscle {
    RECTUS_ABDOMINIS,
    OBLIQUES_INTERNAL,
    OBLIQUES_EXTERNAL,
    TRANSVERSE_ABDOMINIS
}

enum class FrontAbsMuscle {
    RECTUS_ABDOMINIS_UPPER,
    RECTUS_ABDOMINIS_LOWER,
}

enum class LegMuscle {
    QUADRICEPS,
    HAMSTRINGS,
    GLUTEUS,
    CALVES
}

enum class QuadricepsMuscle {
    VASTUS_LATERALIS,
    VASTUS_MEDIALIS,
    VASTUS_INTERMEDIUS,
    RECTUS_FEMORIS
}

enum class HamstringMuscle {
    BICEPS_FEMORIS,
    SEMITENDINOSUS,
    SEMIMEMBRANOSUS
}

enum class GlutealMuscle {
    GLUTEUS_MAXIMUS,
    GLUTEUS_MEDIUS,
    GLUTEUS_MINIMUS
}

enum class CalfMuscle {
    GASTROCNEMIUS,
    SOLEUS
}

val muscleHierarchy: Map<Enum<*>, List<Enum<*>>> = mapOf(
    // Top-level groups
    MuscleGroup.SHOULDERS to ShoulderMuscle.entries,
    MuscleGroup.CHEST to ChestMuscle.entries,
    MuscleGroup.BACK to BackMuscle.entries,
    MuscleGroup.ARMS to ArmMuscle.entries,
    MuscleGroup.CORE to CoreMuscle.entries,
    MuscleGroup.LEGS to LegMuscle.entries,

    // Shoulder subgroups
    ShoulderMuscle.DELTOIDS to DeltoidMuscle.entries,
    ShoulderMuscle.ROTATOR_CUFF to RotatorCuffMuscle.entries,

    // Back subgroups
    BackMuscle.LATISSIMUS_DORSI to LatsMuscle.entries,
    BackMuscle.TRAPEZIUS to TrapeziusMuscle.entries,

    // Arm subgroups
    ArmMuscle.BICEPS to BicepsMuscle.entries,
    ArmMuscle.TRICEPS to TricepsMuscle.entries,
    ArmMuscle.FOREARM to ForearmMuscle.entries,

    // Core subgroups
    CoreMuscle.RECTUS_ABDOMINIS to FrontAbsMuscle.entries,

    // Leg subgroups
    LegMuscle.QUADRICEPS to QuadricepsMuscle.entries,
    LegMuscle.HAMSTRINGS to HamstringMuscle.entries,
    LegMuscle.CALVES to CalfMuscle.entries,
    LegMuscle.GLUTEUS to GlutealMuscle.entries
)